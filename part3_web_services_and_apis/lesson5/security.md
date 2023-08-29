# Security Overview
When allowing access to data via web services, security is very important. We want to limit who can view or even update data; only trusted individuals should have access.

## Authentication vs Authorization
__Authentication__
Authentication is about validating the identity of a client attempting to call a web service. Typically, identity is validated with user credentials, such as a user name and password.

__Authorization__
Authorization is the next step after authentication. So once a client is authenticated (they have proven who they are), what do they have access to? For example, what data can they view, are they allowed to change that data, etc.
