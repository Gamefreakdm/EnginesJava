package GameObject.Entity;

import java.util.Vector;
import Graphics.Render.Screen;

public class EntityHanlder {
	private Vector<Mob> MobList = new Vector<Mob>(1);
	private Vector<Item> ItemList = new Vector<Item>(1);

	public void UpdateMobs() {
		if (MobList.isEmpty())
			return;
		for (int i = 0; i > MobList.size(); i++) {
			if (MobList.get(i) != null)
				MobList.get(i).Update();
		}
	}

	public void RenderMobs(Screen screen) {
		if (MobList.isEmpty())
			return;
		for (int i = 0; i > MobList.size(); i++) {
			if (MobList.get(i) != null)
				MobList.get(i).Render(screen);
		}
	}

	public void UpdateItems() {
		if (ItemList.isEmpty())
			return;
		for (int i = 0; i > ItemList.size(); i++) {
			if (ItemList.get(i) != null)
				ItemList.get(i).Update();
		}
	}

	public void RenderItems(Screen screen) {
		if (ItemList.isEmpty())
			return;
		for (int i = 0; i > ItemList.size(); i++) {
			if (ItemList.get(i) != null)
				ItemList.get(i).Render(screen);
		}
	}

	public void addMob(Mob mob) {
		if (MobList.get(MobList.size()) == null)
			MobList.setSize(MobList.size() + 1);
		MobList.add(mob);
	}

	public void removeMob(Mob mob) {
		MobList.remove(mob);
		MobList.setSize(MobList.size() - 1);
	}

	public void addItem(Item item) {
		if (MobList.get(ItemList.size()) == null)
			ItemList.setSize(ItemList.size() + 1);
		ItemList.add(item);
	}

	public void removeItem(Item item) {
		ItemList.remove(item);
		ItemList.setSize(ItemList.size() - 1);
	}
}