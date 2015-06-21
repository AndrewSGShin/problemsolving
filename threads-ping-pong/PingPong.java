class PingPong {

	private static Object lock = new Object();

	private static volatile boolean sync = false; 

	public static void main(String... args) {
		new Thread(PingPong::runPing, "Ping").start();
		new Thread(PingPong::runPong, "Pong").start();
	}

	public static void runPing () {
		while (true) {
			if (sync) {
				System.out.println(Thread.currentThread().getName());
				sync = false;
			}
		}
	}

	public static void runPong () {
		while (true) {
			if (!sync) {
				System.out.println(Thread.currentThread().getName());
				sync = true;
			}
		}
	}
}