package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public int width, height;
    public Vector2D anchor;


    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;

    }


    public double top() {
        return position.y - anchor.y * height;
    }

    public double bot() {
        return top() + height;
    }

    public double left() {
        return position.x - anchor.x * width;
    }

    public double right() {
        return left() + width;
    }

    /**
     *
     */
    public boolean intersects(BoxCollider other) {
        return other.right() >= this.left()
                && other.left() <= this.right()
                && other.bot() >= this.top()
                && other.top() <= this.bot();
    }
}