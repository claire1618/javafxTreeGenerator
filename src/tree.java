import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class tree extends Application {

    public void start(Stage stage1){
        int runTimes[] = {0};
        int times = runTimes[0];
        Button redo = new Button("Reset");
        Button yellow = new Button("Fall");

        Pane root = createPane(redo, yellow);
        createLeaves(root);
        makeGravestones(root);

        Scene scene1 = new Scene(root);

        stage1.setScene(scene1);
        stage1.setTitle("TREEEEE");

        redo.setOnAction(event ->{
                stage1.setScene(new Scene(normalLeaves(redo, yellow)));
                runTimes[0] = 0;});
        yellow.setOnAction(event ->{
                stage1.setScene(new Scene(makeYelLeaves(runTimes[0], redo, yellow)));
                runTimes[0]++;});

        stage1.show();
    }

    public Pane normalLeaves(Button redo, Button yellow){
        Pane hold = new Pane(createPane(redo, yellow));
        createLeaves(hold);
        Pane hold2 = makeGravestones(hold);
        return hold2;
    }

    public Pane makeYelLeaves(int times, Button redo, Button yellow){
        Pane hold = new Pane(createPane(redo, yellow));
        yellowLeaves(hold, times);
        return hold;
    }

    public Pane createPane(Button redo, Button yellow){
        redo.relocate(10, 10);
        yellow.relocate(10, 50);

        /*
        SKY SECTION
         */
        Rectangle sky = new Rectangle(0, 0, 800, 475);
        Rectangle sky2 = new Rectangle(0, 75, 800, 400);
        Rectangle sky3 = new Rectangle(0, 175, 800, 300);
        Rectangle sky4 = new Rectangle(0, 250, 800, 225);
        Rectangle sky5 = new Rectangle(0, 325, 800, 150);

        sky.setFill(Color.rgb(62,0,133));
        sky2.setFill(Color.rgb(48,0,120, .3));
        sky3.setFill(Color.rgb(40,0,115, .3));
        sky4.setFill(Color.rgb(35,0,100, .3));
        sky5.setFill(Color.rgb(25,0,90, .3));

        /*
        GROUND SECTION
         */
        Rectangle ground = new Rectangle(0, 475, 800, 325);
        Rectangle ground2 = new Rectangle(0, 600, 800, 200);
        Rectangle ground3 = new Rectangle(0, 660, 800, 140);
        Rectangle ground4 = new Rectangle(0, 730, 800, 70);

        ground.setFill(Color.rgb(60,55,0));
        ground2.setFill(Color.rgb(45,45,0));
        ground3.setFill(Color.rgb(35,40,0));
        ground4.setFill(Color.rgb(28,35,0));

        /*
        TREE SECTION
         */
        Arc test = new Arc(550, 400, 100, 100, 185, 75);
        Arc test1 = new Arc(250, 400, 100, 100, -80, 75);
        Arc branch1 = new Arc(285, 335, 75, 75, 30, 50);
        Arc branch2 = new Arc(520, 330, 75, 75, 110, 50);

        Line trunk1 = new Line(350, 410, 350, 300);
        Line trunk2 = new Line(450, 410, 450, 300);

        Rectangle trunkR = new Rectangle(350, 300, 100, 200);

        Polygon trunk = new Polygon(265, 500, 315, 475, 330, 460, 345, 420,
                345, 375, 450, 430, 445, 370, 483, 475, 540, 500);

        test.setType(ArcType.OPEN);
        test1.setType(ArcType.OPEN);
        branch1.setType(ArcType.OPEN);
        branch2.setType(ArcType.OPEN);

        test.setStroke(Color.rgb(82, 54, 27));
        test1.setStroke(Color.rgb(82, 54, 27));
        branch1.setStroke(Color.rgb(82, 54, 27));
        branch2.setStroke(Color.rgb(82, 54, 27));
        trunk1.setStroke(Color.rgb(82, 54, 27));
        trunk2.setStroke(Color.rgb(82, 54, 27));
        trunk.setFill(Color.rgb(82, 54, 27));
        trunkR.setFill(Color.rgb(82, 54, 27));

        test.setFill(null);
        test1.setFill(null);
        branch1.setFill(null);
        branch2.setFill(null);

        test.setStrokeWidth(20);
        test1.setStrokeWidth(20);
        branch1.setStrokeWidth(20);
        branch2.setStrokeWidth(20);
        trunk1.setStrokeWidth(20);
        trunk2.setStrokeWidth(20);

        /*
        PANE DECLARATION
         */
        Pane root = new Pane(sky, sky2, sky3, sky4, sky5, ground, ground2, ground3, ground4, test, test1, trunk1, trunk2,
                branch1, branch2, trunk, trunkR, redo, yellow);
        root.setMinSize(800, 800);

        /*
        ADD TRUNKS
         */
        for(int i = 0; i < 70; i++){
            Circle cir = new Circle((Math.random() * 400) + 200, (Math.random() * 350), Math.random() * 50);
            cir.setFill(Color.rgb(82, 54, 27));
            if(cir.getCenterX() <= 300 && cir.getCenterY() >= 300){
                root.getChildren().addAll();
            }else{
                root.getChildren().addAll(cir);
            }
        }


        /*
        DONE
         */

        return root;
    }

    /*
    GRAVESTONE
     */

    public Pane makeGravestones(Pane root){
        Circle starter = new Circle(((Math.random() * 600) + 100), ((Math.random() * 400) + 300), ((Math.random() * 75)), Color.GREY);
        double radius = starter.getRadius();
        double x = starter.getCenterX();
        double y = starter.getCenterY();

        Rectangle startR = new Rectangle((x - radius), y, radius * 2, 75);

        Line l = new Line((startR.getX()), startR.getY(), startR.getX(), startR.getY() + startR.getHeight());
        Line b = new Line(startR.getX(), (startR.getY() + startR.getHeight()), (startR.getX() + startR.getWidth()), (startR.getY() + startR.getHeight()));
        Line r = new Line((startR.getX() + startR.getWidth()), (startR.getY() + startR.getHeight()), (startR.getX() + startR.getWidth()), startR.getY());

        starter.setStrokeWidth(2);
        l.setStrokeWidth(2);
        b.setStrokeWidth(2);
        r.setStrokeWidth(2);

        startR.setFill(Color.GREY);

        starter.setStroke(Color.rgb(75, 75, 75));
        l.setStroke(Color.rgb(75, 75, 75));
        b.setStroke(Color.rgb(75, 75, 75));
        r.setStroke(Color.rgb(75, 75, 75));

        for(int k = 0; k < 3; k++){
            Circle sTop = new Circle(((Math.random() * 600) + 100), ((Math.random() * 400) + 300), ((Math.random() * 75)), Color.GREY);

            Rectangle sBottom = new Rectangle((sTop.getCenterX() - sTop.getRadius()), sTop.getCenterY(), sTop.getRadius() * 2, 75);

            Line left = new Line((sBottom.getX()), sBottom.getY(), sBottom.getX(), sBottom.getY() + sBottom.getHeight());
            Line bttm = new Line(sBottom.getX(), (sBottom.getY() + sBottom.getHeight()), (sBottom.getX() + sBottom.getWidth()), (sBottom.getY() + sBottom.getHeight()));
            Line right = new Line((sBottom.getX() + sBottom.getWidth()), (sBottom.getY() + sBottom.getHeight()), (sBottom.getX() + sBottom.getWidth()), sBottom.getY());

            sTop.setStrokeWidth(2);
            left.setStrokeWidth(2);
            bttm.setStrokeWidth(2);
            right.setStrokeWidth(2);

            Label rip = new Label("RIP");
            rip.setFont(Font.font("",20));

            sBottom.setFill(Color.GREY);

            sTop.setStroke(Color.rgb(75, 75, 75));
            left.setStroke(Color.rgb(75, 75, 75));
            bttm.setStroke(Color.rgb(75, 75, 75));
            right.setStroke(Color.rgb(75, 75, 75));

            if((sTop.getCenterY() <= 400) || (sTop.getCenterX() >= 300 && sTop.getCenterX() <= 400) ||
                    (sTop.getRadius() <= 30) ||
                    (((x + radius + 100) >= sTop.getCenterX()) && (x - radius - 100) <= sTop.getCenterX()) ||
                    (((y + radius + 100) >= sTop.getCenterY()) && ((y - radius - 100) <= sTop.getCenterY()))){
                k--;
            }else{
                root.getChildren().addAll(sTop, sBottom, left, bttm, right);
            }
            radius = sTop.getRadius();
            x = sTop.getCenterX();
            y = sTop.getCenterY();
        }
        return root;
    }

    public Pane createLeaves(Pane root){

        root.getChildren().removeAll();

        for(int k = 0; k < 700; k++){
            int c = ((int)(Math.random() * 600)) + 75;
            int d = (int)(Math.random() * 400);

            Polygon leafBack = new Polygon(c + 23, d - 27, c + 12, d - 18, c + 20, d, c + 35, d - 2, c + 38, d - 17);
            leafBack.setFill(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 200), 0));

            Group holdLeaf = new Group(leaf(c, d, leafBack));
            root.getChildren().addAll(holdLeaf);
        }
        return root;
    }

    public Pane yellowLeaves(Pane root, int runTimes){

        for(int k = 0; k < 700; k++){
            int choice = ((int)(Math.random() * 10) + runTimes);
            int c = ((int)(Math.random() * 600)) + 75;
            int d = (int)(Math.random() * 400);

            Polygon leafBack = new Polygon(c + 23, d - 27, c + 12, d - 18, c + 20, d, c + 35, d - 2, c + 38, d - 17);

            if(choice == 1){
                leafBack.setFill(Color.rgb(255,206,44));
                leafBack.setStroke(Color.rgb(255,206,44));
            }else if(choice == 2){
                leafBack.setFill(Color.rgb(255,174,44));
                leafBack.setStroke(Color.rgb(255,174,44));
            }else if(choice == 3){
                leafBack.setFill(Color.rgb(255,150,44));
                leafBack.setStroke(Color.rgb(255,150,44));
            }else if(choice == 4){
                leafBack.setFill(Color.rgb(255,149,60));
                leafBack.setStroke(Color.rgb(255,149,60));
            }else if(choice == 5){
                leafBack.setFill(Color.rgb(255,137,44));
                leafBack.setStroke(Color.rgb(255,137,44));
            }else if(choice == 6){
                leafBack.setFill(Color.rgb(255,115,44));
                leafBack.setStroke(Color.rgb(255,115,44));
            }else if(choice == 7){
                leafBack.setFill(Color.rgb(255,88,44));
                leafBack.setStroke(Color.rgb(255,88,44));
            }else if(choice == 8){
                leafBack.setFill(Color.rgb(255,72,60));
                leafBack.setStroke(Color.rgb(255,72,60));
            }else if(choice == 9){
                leafBack.setFill(Color.rgb(204,71,35));
                leafBack.setStroke(Color.rgb(204,71,35));
            } else{
                leafBack.setFill(Color.rgb(128,69,22));
                leafBack.setStroke(Color.rgb(128,69,22));
            }

            Group fuck =  new Group(leaf(c, d, leafBack));
            root.getChildren().addAll(fuck);
        }
        return root;
    }

    public Group leaf(int c, int d, Polygon leafBack){
        Group holdLeaf = new Group();

        Arc Side1 = new Arc(c, d, 20, 20, 0, 50);
        Arc Side2 = new Arc(c + 30, d + 18, 20, 20, 72, 50);
        Arc Side3 = new Arc(c + 55, d - 7, 20, 20, 144, 50);
        Arc Side4 = new Arc(c + 41, d - 38, 20, 20, 216, 50);
        Arc Side5 = new Arc(c + 5, d - 36, 20, 20, 288, 50);

        Line Stem = new Line(c + 27, d, c + 30, d + 10);
        Stem.setStrokeWidth(2);
        Side1.setType(ArcType.OPEN);
        Side2.setType(ArcType.OPEN);
        Side3.setType(ArcType.OPEN);
        Side4.setType(ArcType.OPEN);
        Side5.setType(ArcType.OPEN);

        Side1.setFill(Color.rgb(40,0,115, .3));
        Side2.setFill(Color.rgb(40,0,115, .3));
        Side3.setFill(Color.rgb(40,0,115, .3));
        Side4.setFill(Color.rgb(40,0,115, .3));
        Side5.setFill(Color.rgb(40,0,115, .3));

        Side1.setStroke(leafBack.getFill());
        Side2.setStroke(leafBack.getFill());
        Side3.setStroke(leafBack.getFill());
        Side4.setStroke(leafBack.getFill());
        Side5.setStroke(leafBack.getFill());
        Stem.setStroke(leafBack.getFill());

        if(((Side1.getCenterX() <= 200) && (Side1.getCenterY() >= 350)) ||
                ((Side1.getCenterX() >= 600) && (Side1.getCenterY() >= 350)) ||
                ((Side1.getCenterX() <= 175) && (Side1.getCenterY() >= 300)) ||
                ((Side1.getCenterX() >= 625) && (Side1.getCenterY() >= 300))){
            holdLeaf.getChildren().addAll();
        } else{
            holdLeaf.getChildren().addAll(leafBack, Side1, Side2, Side3, Side4, Side5, Stem);
        }

        return holdLeaf;
    }
}