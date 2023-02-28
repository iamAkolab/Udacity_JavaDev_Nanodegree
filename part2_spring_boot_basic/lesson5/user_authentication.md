# Practical Example: User Credentials and Authentication

## Authentication in a web application
User support is a common feature in web applications, which means that a user can register an account and use credentials to login to the application in the future.

It's important to design databases with the assumption that they will someday be breached, and so we cannot store passwords or other secret credentials in plain text. Two approaches to storing passwords are:

* Encryption: Modifying data before storing it, with the intention of using another algorithm to return the data to its original form once it needs to be used.
* Hashing: Modifying data before storing it with the intention of never returning it to its original form. The modified data will be compared to other modified data only.

Hashing and Encryption should occur in a service dedicated to that purpose, rather than on the front end or in the controller. Hashing sometimes makes use of another technique, Salting. For a more in-depth discussion of salting and hashing passwords, see the further research section below the videos for this section.

## The flow of data
Remember the separation of concerns and our onion architecture! The idea is that all user flows originate externally, travel through a controller, then through one or more services, finally through a data access bean to the database, and then all the way back up the chain. Structuring applications this way makes it easy to follow dependencies and separate concerns, so that's how we're going to build applications from now on.

Hashing Implementation
Below is an example of how to hash user passwords in the database. First, we have the User class and the UserMapper. When our UserService creates a new user, it uses a hashing service to convert the password to a hashed value before saving it.
```
User.java
```
```
public class User {
    private Integer userId;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;
    /* constructor, getters, and setters omitted */
}
```
```
UserMapper.java
```
```
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);
}
```
```
Method in UserService.java
```
```
public int createUser(User user) {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    String encodedSalt = Base64.getEncoder().encodeToString(salt);
    String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
    return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));
}
```
The hashing service itself has a single method that takes some data and salt and creates a string representing the hashed value.
* Salt: random data that is combined with the input string when hashing so that the resultant hashed values are unique for each row. This means that two users with the same password would not have the same hash in the database.

```
Method in HashService.java
```
```
public String getHashedValue(String data, String salt) {
    byte[] hashedValue = null;

    KeySpec spec = new PBEKeySpec(data.toCharArray(), salt.getBytes(), 5000, 128);
    try {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        hashedValue = factory.generateSecret(spec).getEncoded();
    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
        logger.error(e.getMessage());
    }

    return Base64.getEncoder().encodeToString(hashedValue);
}
```
## Authentication Implementation
When a user logs in, we have no way to retrieve their original password, but we can re-hash their user input and see if it matches the hashed value in our database. Below is an example AuthenticationService class that implements a Spring interface, the AuthenticationProvider. This allows Spring to integrate our provider with many different authentication schemes, but we can see in our supports method that we specify that we only support UsernamePasswordAuthentication.

The authenticate() method takes an Authentication object from spring and returns an authentication token if the user's credentials are correct.
```
AuthenticationService.java
```
```
@Service
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    private HashService hashService;

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
```
In order for Spring to actually use our AuthenticationService, we need to extend our Web Security configuration. We do that with an adapter for the WebSecurityConfigurer. This example overrides two configure methods:

* configure(AuthenticationManagerBuilder auth): used to tell Spring to use our AuthenticationService to check user logins
* configure(HttpSecurity http): used to configure the HttpSecurity object by chaining methods to express security requirements

```
SecurityConfig.java
```
```
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .permitAll();

        http.formLogin()
                .defaultSuccessUrl("/home", true);
    }
}
```

We can see that the second configure method does four things:
* Allows all users to access the /signup page, as well as the css and js files.
* Allows authenticated users to make any request that's not explicitly covered elsewhere.
* Generates a login form at /login and allows anyone to access it.
* Redirects successful logins to the /home page.

## Key Terms
* Onion Pattern: Sometimes also called Tiered Architecture, Multi-tiered Architecture, or n-tiered Architecture. This is a design pattern that separates areas of the application into controller, service, and data layers (and sometimes more). User flows originate from the controller tier, which passes them to the service tier, which then reaches a data access bean.
* Encryption: Modifying data before storing it, with the intention of using another algorithm to return the data to its original form once it needs to be used.
* Hashing: Modifying data before storing with the intention of never returning it to its original form. The modified data will be compared to other modified data only.
* Salt: random data that is combined with the input string when hashing so that the resultant hashed values are unique for each row. This means that two users with the same password would not have the same hash in the database.
