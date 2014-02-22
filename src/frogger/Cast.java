package frogger;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Cast {
	ArrayList<Sprite> castList; 
								
	public Cast() {
		this.castList = new ArrayList<Sprite>();
	}

	/**
	 * add a sprite to the cast
	 * @param sprite the sprite to be added to the cast
	 */
	public void addSprite(Sprite sprite) {
		if (sprite == null) {
			throw new NullPointerException("Null arg in Cast.addSprite()");
		}
		this.castList.add(sprite);
	}

	/**
	 * remove a sprite from the cast
	 * @param sprite the sprite to be removed
	 */
	public void removeSprite(Sprite sprite) {
		if (!castList.contains(sprite)) {
			throw new NoSuchElementException(
					"Cast.removeSprite() - sprite arg is not contained in ArrayList");
		}
		this.castList.remove(sprite);
	}

	public ArrayList<Sprite> getCastList() {
		return castList;
	}
}
