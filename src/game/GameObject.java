package game;


import game.physics.BoxCollider;
import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle (Class<E> cls) {
        /**
         1. find something inactive >> if founded >> reset >> return
         2. if not >> create new
         */
        E object = findInactive(cls);
        if (object != null) {
            object.reset();
            return object;
        }

        try{
            object = cls.getConstructor().newInstance();
            return object;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <E extends GameObject> E findInactive(Class<E> cls) {

        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(object.getClass())
            && !object.active) {
                return (E) object;
            }
        }
        return null;
    }


    public static <E extends GameObject> E findIntersects (Class<E> cls, BoxCollider hitbox){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                && object.hitBox != null
                && object.hitBox.intersects(hitbox)
                && cls.isAssignableFrom(object.getClass())) {
                    return  (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E find(Class<E> cls) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }

    public static void renderAll(Graphics g) {
//        System.out.println(objects.size());
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    public static void runAll() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void clearAll() {
        objects.clear();

    }
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox;
    public  boolean active;
    public Vector2D anchor;


    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        anchor = new Vector2D(0.5, 0.5);
        active = true;
    }


    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, this);
        }
     }
    public void run() {
        position.add(velocity.x, velocity.y);
    }
    public void deactive(){
        active = false;
    }
    public void reset(){
        active = true;
    }
}
