package Graphics.Render;

public class BackroundHandler {
	private String pastgs;
	private Backround Curback;

	public void Update(String gs) {
		if (pastgs == gs)
			return;
		switch (gs) {
		}
		pastgs = gs;
	}

	public Backround getCurBack() {
		return Curback;
	}
}