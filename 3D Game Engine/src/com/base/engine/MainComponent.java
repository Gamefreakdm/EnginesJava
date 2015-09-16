package com.base.engine;

class MainComponent {
	private boolean Running;
	private static final int WIDTH = 800, HEIGHT = 600;
	private static final String TITLE = "Testing Engine";

	public static void main(String[] args) {
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		MainComponent MC = new MainComponent();
		MC.Start();
	}

	public void Start() {
		if (Running)
			return;
		Run();
	}

	private void Run() {
		Running = true;
		while (Running) {
			Update();
			Render();
			if (Window.IsCloseRequested())
				Stop();
		}
	}

	private void Render() {
		Window.Render();
	}

	private void Update() {
	}

	public void Stop() {
		if (!Running)
			return;
		CleanUp();
		Running = false;
	}

	private void CleanUp() {
		Window.Dispose();
	}
}