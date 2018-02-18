package arm;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Arm {
    double F = 50;
    double T = 70;

    float alphaColor;

    PApplet context;
    PShape base, shoulder, upArm, loArm, end;
    double alpha, beta, gamma;


    public Arm(PApplet pApplet){
        context     = pApplet;

        base        = context.loadShape("r5.obj");
        shoulder    = context.loadShape("r1.obj");
        upArm       = context.loadShape("r2.obj");
        loArm       = context.loadShape("r3.obj");
        end         = context.loadShape("r4.obj");

        alphaColor = 40.0f;

        shoulder.disableStyle();
        upArm.disableStyle();
        loArm.disableStyle();


    }



    public void drawArm(double _alpha,double _beta,double _gamma){
        alpha = _alpha;
        beta  = _beta;
        gamma = _gamma;
        drawArm();
    }

    public void drawArm(){

        context.noStroke();

        context.scale(-1.20f);

        //gamma = (PApplet.radians(context.frameCount));

        //base no rotatoria
        context.fill(255, 227, 8,alphaColor);
        context.translate(0,26,0);
        context.shape(base);
        //base rotatoria
        context.translate(0, 4, 0);
        context.rotateY((float) gamma);
        context.shape(shoulder);
        //antebrazo
        context.fill(66, 244, 131,alphaColor);
        context.translate(0, 25, 0);
        context.rotateY(context.PI);
        context.rotateX((float) alpha);
        context.shape(upArm);
        //brazo
        context.translate(0, 0, 50);
        context.rotateY(context.PI);
        context.rotateX((float) beta);
        context.shape(loArm);
        //orientacion (NO USADA)
        context.translate(0, 0, -50);
        context.rotateY(context.PI);
        context.shape(end);

    }


    public double getF() {
        return F;
    }

    public double getT() {
        return T;
    }
}
