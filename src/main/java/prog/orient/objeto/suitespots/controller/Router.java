package prog.orient.objeto.suitespots.controller;

import java.util.Stack;

import javax.swing.JFrame;

import prog.orient.objeto.suitespots.views.Home;

public class Router {

    private static Router routerInstance;
    private Stack<JFrame> stack;

    public Router() {
        stack = new Stack<JFrame>();
    }

    public static Router getInstance() {
        if (routerInstance == null) {
            routerInstance = new Router();
        }
        return routerInstance;
    }

    public void setHome(JFrame jFrame) {
        if (stack.empty()) {
            stack.push(jFrame);
        }
    }

    public void push(JFrame jFrame) {
        if (!stack.empty()) {
            JFrame prevFrame = stack.peek();
            prevFrame.dispose();
        }

        stack.push(jFrame);
        jFrame.setVisible(true);
    }

    public void pop() {
        if (!stack.empty()) {
            JFrame curFrame = stack.pop();
            curFrame.dispose();
            if (!stack.empty()) {
                JFrame prevFrame = stack.peek();
                prevFrame.setVisible(true);
            } else {
                JFrame homePage = new Home();
                homePage.setVisible(true);
            }
        }
    }
}
