public int fibonacciIterative(int n) {
  If(n <= 1) return n;
  Int a = 1, b = 1
  for(int i =2; i < n; i++) {
    int temp = a;
    a += b;
    b = temp;
  }
  returm a;
}

// Recursive
