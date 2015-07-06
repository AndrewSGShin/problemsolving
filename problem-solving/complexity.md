# Calculate time complexity

- input model (use both - PRNG data and reproducable text files - for testing)
- inner loop
- cost model
- mathematical analysis (worst cast performance guarantees / probabilistic guarantees / best case)
	+ floor \N/
	+ ceiling /N\
	+ natural logarithm lnN
	+ binary logarithm lgN
	+ integer binary logarithm \lgN/
	+ harmonic numbers Hn = 1+ 1/2 + 1/3 + 1/4 + ... + 1/n ~ ln N 
	+ factorial n! = 1*2*3*...*n = 
	+ triangular sum = 1 + 2 + 3 + ... + N ~ (N**2)/2
	+ geometric sum = 1 + 2 + 4 + 8 + ... + N = 2N - 1 ~ 2N
	+ stirlings approximation lg N! = lg1 + lg2 + ... + ...lgN ~ N lg N
	+ binomial coefficients
	+ exponential (1 - 1/x) ** x ~ 1/e
- standard plot & log-log plot
- tilde approximation f(N) ~ g(N) is limN→∞ f (N )/g (N ) = 1
- order of growth
	+ constant (1)
	+ logarithmic (logn)
	+ linear (n)
	+ linearithmic (nlogn)
	--------------------------- can't meet the Moore's Law
	+ quadratic (n**2)
	+ cubic (n**3)
	+ exponential (2**n)
- amortized analysis (average cost per operation)
- doubling ratio experiments to prove

# Calculate space complexity
- object overhead ~ 16 bytes (reference to class object, gc and synchronization information)
- pad to 8 bytes boundary
- reference, long, double ~ 8 bytes
- int, float ~ 4 bytes
- boolean, byte ~ 1 byte
- char ~ 2 bytes
- closures ~ 8 bytes for enclosing object reference
- array ~ 16 bytes object overhead, 4 bytes for length, 4 bytes padding + data
- for recursive algos calculate stack size (local variables, return address at least)

# Caveats
- large constants
- nondominant ineer loop
- instruction time (caching)
- system considerations

# Big O
- f(N) is O(g(N)) if there exist constants c and N0 such that |f(N)| < c g(N) for all N > N0. 
- f(N) is 􏰄Omega(g(N)) if there exist constants c and N0 such that |f(N)| > c g(N) for N > N0.
- if f(N) is O(g(N)) and 􏰄Omega(g(N)), then f(N) is 􏰅Theta(g(N)). The “big-Omega” notation is typically used to describe a lower bound on the worst case, and the “big-Theta” notation is typically used to describe the performance of algorithms that are optimal in the sense that no algorithm can have better asymptotic worst-case order of growth.

# Other
- cell probe model - A model of computation where we only count accesses to a random-access memory large enough to hold the input and consider all other operations to be free.
