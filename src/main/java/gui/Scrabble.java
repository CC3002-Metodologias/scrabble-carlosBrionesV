

package gui;

import AST.AST;
import AST.Operations.Operation;
import AST.Operations.*;
import AST.ScrabFactory;


import Exceptions.NullException;
import Exceptions.TypeException;
import STypes.ScrabType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * GUI Class
 */
public class Scrabble extends Application {

    private final ScrabFactory factory = new ScrabFactory();
    private final HashMap<StackPane, ScrabNode> Nodes = new HashMap<>();
    private final HashMap<String, StackPane> Lines = new HashMap<>();

    private final AST ast = new AST();
    private boolean first = false;
    private boolean error = false;

    private final TextField currentTypetxt = new TextField();
    private final TextField txtresult = new TextField();
    private final TextField VarName=new TextField();
    private final TextField VarValue=new TextField();
    private final TextField txtNodeValue=new TextField();
    private final Pane bigpane = new Pane();
    private final Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(1)));

    private final int nodeX=35;
    private final int nodeY=150;
    private final int nodeR=30;

    /**
     * to start the window
     * @param primaryStage the Stage
     */
    @Override
    public void start(Stage primaryStage) {

        int width=800;
        int height=600;



        //FONDO

        bigpane.setPrefSize(width,height);

        HBox NodeMenu = new HBox();
        NodeMenu.setAlignment(Pos.TOP_CENTER);
        NodeMenu.setPrefSize(width,height/4.5);


        HBox SetBox = new HBox();
        VBox TypeBox = new VBox();
        GridPane btnscrabs = new GridPane();

        //buttons for SCRABS
        Button Int = new Button("Int");
        GridPane.setRowIndex(Int,0);
        GridPane.setColumnIndex(Int,0);
        Int.setOnAction(this::setType);

        Button Binary = new Button("Binary");
        GridPane.setRowIndex(Binary,0);
        GridPane.setColumnIndex(Binary,1);
        Binary.setOnAction(this::setType);

        Button Float = new Button("Float");
        GridPane.setRowIndex(Float,0);
        GridPane.setColumnIndex(Float,2);
        Float.setOnAction(this::setType);

        Button Bool = new Button("Boolean");
        GridPane.setRowIndex(Bool,1);
        GridPane.setColumnIndex(Bool,0);
        Bool.setOnAction(this::setType);

        Button String = new Button("String");
        GridPane.setRowIndex(String,1);
        GridPane.setColumnIndex(String,1);
        String.setOnAction(this::setType);

        Button Var = new Button("Var");
        GridPane.setRowIndex(Var,1);
        GridPane.setColumnIndex(Var,2);
        Var.setOnAction(this::setType);

        btnscrabs.getChildren().addAll(Int,Float,Binary,Bool,String,Var);

        //TO MAKE A SCRAB
        TitledPane Scrabs = new TitledPane("Set to Scrabble",btnscrabs);


        GridPane btnOps = new GridPane();

        //buttons for OPERATIONS

        Button And = new Button("And");
        GridPane.setRowIndex(And,0);
        GridPane.setColumnIndex(And,0);
        And.setOnAction(this::setType);

        Button Or = new Button("Or");
        GridPane.setRowIndex(Or,0);
        GridPane.setColumnIndex(Or,1);
        Or.setOnAction(this::setType);

        Button Add = new Button("Addition");
        GridPane.setRowIndex(Add,0);
        GridPane.setColumnIndex(Add,2);
        Add.setOnAction(this::setType);

        Button Minus = new Button("Subtract");
        GridPane.setRowIndex(Minus,1);
        GridPane.setColumnIndex(Minus,0);
        Minus.setOnAction(this::setType);

        Button Mult = new Button("Multiplication");
        GridPane.setRowIndex(Mult,1);
        GridPane.setColumnIndex(Mult,1);
        Mult.setOnAction(this::setType);

        Button Div = new Button("Division");
        GridPane.setRowIndex(Div,1);
        GridPane.setColumnIndex(Div,2);
        Div.setOnAction(this::setType);

        btnOps.getChildren().addAll(Div,Mult,Add,Minus,And,Or);

        //TO MAKE A OPERATION
        TitledPane Op = new TitledPane("Set to operation",btnOps);

        SetBox.getChildren().addAll(Scrabs,Op);

        HBox current = new HBox();
        Label currentTypeLabel = new Label("New Node Type: ");
        currentTypeLabel.setFont(new Font("Arial",15));

        currentTypetxt.setDisable(true);
        currentTypetxt.setBorder(border);
        currentTypetxt.setPrefWidth(150);
        currentTypetxt.setAlignment(Pos.CENTER);
        currentTypetxt.setStyle("-fx-font-size: 19px; -fx-opacity: 1;");

        current.getChildren().addAll(currentTypeLabel,currentTypetxt);
        TypeBox.getChildren().addAll(SetBox,current);

        //INPUT , CREATION & EVALUATION
        VBox input = new VBox();

        VBox newNodeBox = new VBox();

        txtNodeValue.setPromptText("Enter value or var Name if necesary");
        Button createNode= new Button("Create new Node");
        createNode.setOnAction(this::NewNode);

        newNodeBox.getChildren().addAll(txtNodeValue,createNode);
        newNodeBox.setBorder(border);

        VBox newVarBox = new VBox();
        HBox varsInfo = new HBox();

        VarName.setPromptText("Name");
        VarValue.setPromptText("Value");

        varsInfo.getChildren().addAll(VarName,VarValue);

        Button createVar= new Button("Create new Var");
        createVar.setOnAction(this::NewVar);

        HBox EvalBox = new HBox();
        Label resultLabel=new Label("  result: ");
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setFont(new Font("Arial",15));

        txtresult.setBorder(border);
        txtresult.setDisable(true);
        txtresult.setStyle("-fx-font-size: 19px; -fx-opacity: 1;");

        Button Eval= new Button("Evaluate Tree");
        Eval.setOnAction(this::Eval);


        newVarBox.setBorder(border);

        EvalBox.getChildren().addAll(Eval,resultLabel,txtresult);

        newVarBox.getChildren().addAll(varsInfo,createVar);

        input.getChildren().addAll(newNodeBox,newVarBox,EvalBox);

        NodeMenu.getChildren().addAll(TypeBox,input);

        NodeMenu.setBorder(border);

        bigpane.getChildren().add(NodeMenu);

        Scene scene = new Scene(bigpane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * main
     * @param args no args
     */
    public static void main(String[] args) {
            launch(args);
    }

    /**
     * function to set a type
     * @param event the event that triggered this
     */
    public void setType(ActionEvent event){
        Button button = (Button) event.getSource();
        currentTypetxt.setText(button.getText());
    }

    /**
     * function to create a new var
     * (is empty)
     * @param event the event that triggered this
     */
    public void NewVar(ActionEvent event){
        String Name=VarName.getText();
        String Value= VarValue.getText();
        String type = currentTypetxt.getText();
        switch(type){
            case "int":
                break;
            case "String":
                break;
            case "Boolean":
                break;
            case "Float":
                break;
            case "Binary":
                break;
            default:
                System.out.println("Scrabble type not specified");
        }
    }

    /**
     * function to create a new node
     * @param event the event that triggered this
     */
    public void NewNode(ActionEvent event){

        Circle circle=new Circle();

        circle.setRadius(nodeR);

        circle.setStroke(Color.BLACK);

        Operation value = null;
        String nodeValue = txtNodeValue.getText();
        String type = currentTypetxt.getText();

        Text label = new Text(nodeValue);

        StackPane stack =new StackPane();
        //stack.setBorder(border);
        stack.setLayoutX(nodeX);
        stack.setLayoutY(nodeY);

        Line op1 = new Line();
        Line op2 = new Line();
        op1.setStartX(stack.getLayoutX()+nodeR);
        op1.setStartY(stack.getLayoutY()+nodeR);
        op1.setEndX(op1.getStartX()-nodeR*1.3);
        op1.setEndY(op1.getStartY()+nodeR*1.3);
        op1.setStroke(Color.BLACK);
        op1.setStrokeWidth(5);
        dragAndDropLine(op1);

        op2.setStartX(stack.getLayoutX()+nodeR);
        op2.setStartY(stack.getLayoutY()+nodeR);
        op2.setEndX(op2.getStartX()+nodeR*1.3);
        op2.setEndY(op2.getStartY()+nodeR*1.3);
        op2.setStroke(Color.BLACK);
        op2.setStrokeWidth(5);
        dragAndDropLine(op2);


        ScrabNode scrab = new ScrabNode();
        scrab.setLine1(op1);
        scrab.setLine2(op2);

        setDraggable(stack);
        dragAndDropNode(stack);

        stack.getChildren().addAll(circle,label);
        bigpane.getChildren().addAll(op1,op2,stack);
        Nodes.put(stack, scrab);

        Lines.put(Integer.toString(op1.hashCode()),stack);
        Lines.put(Integer.toString(op1.hashCode()),stack);



        switch(type){
            case "Int":
                try {
                    value = factory.createInt(Integer.parseInt(nodeValue));
                    bigpane.getChildren().removeAll(op1,op2);
                    circle.setFill(new Color(1,0.7,0,1));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println( "Wrong Format in Value");
                    bigpane.getChildren().removeAll(stack);
                    Nodes.remove(stack);
                    Lines.remove(Integer.toString(op1.hashCode()));
                    Lines.remove(Integer.toString(op2.hashCode()));
                    error=true;
                }

            case "String":
                value=factory.createString(nodeValue);
                circle.setFill(new Color(1,0.7,0,1));
                bigpane.getChildren().removeAll(op1,op2);
                break;

            case "Boolean":
                try{
                    checkbool(nodeValue);
                    value=factory.createBoolean(Boolean.parseBoolean(nodeValue));
                    circle.setFill(new Color(1,0.7,0,1));
                    bigpane.getChildren().removeAll(op1,op2);
                    break;
                } catch (TypeException e) {
                    System.out.println(e.getMessage());
                    bigpane.getChildren().removeAll(stack);
                    Nodes.remove(stack);
                    error=true;
                }

            case "Float":
                try{
                    value=factory.createFloat(Float.parseFloat(nodeValue));
                    circle.setFill(new Color(1,0.7,0,1));
                    bigpane.getChildren().removeAll(op1,op2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong Format in value");
                    bigpane.getChildren().removeAll(stack);
                    Nodes.remove(stack);
                    Lines.remove(Integer.toString(op1.hashCode()));
                    Lines.remove(Integer.toString(op2.hashCode()));
                    error=true;
                }

            case "Binary":
                try {
                    checkBinary(nodeValue);
                    value = factory.createBinary(nodeValue);
                    circle.setFill(new Color(1, 0.7, 0, 1));
                    bigpane.getChildren().removeAll(op1,op2);
                    break;
                }catch(TypeException e){
                    System.out.println(e.getMessage());
                    bigpane.getChildren().removeAll(stack);
                    Nodes.remove(stack);
                    Lines.remove(Integer.toString(op1.hashCode()));
                    Lines.remove(Integer.toString(op2.hashCode()));
                    error=true;
                }
            case"Var":
                break;


            case "Or":
                label.setText("||");
                label.setStyle("-fx-font-size: 24");
                value=new Or();


                circle.setFill(new Color(0.2,1,0,1));

                break;
            case "And":
                label.setText("&&");
                label.setStyle("-fx-font-size: 24");

                value=new And();


                circle.setFill(new Color(0.2,1,0,1));

                break;
            case "Subtract":
                label.setText("-");
                label.setStyle("-fx-font-size: 24");

                value=new Minus();


                circle.setFill(new Color(0.2,1,0,1));
                Nodes.put(stack,scrab);
                break;
            case "Multiplication":
                label.setText("*");
                label.setStyle("-fx-font-size: 24");

                value=new Mult();


                circle.setFill(new Color(0.2,1,0,1));
                Nodes.put(stack,scrab);
                break;
            case "Division":
                label.setText("/");
                label.setStyle("-fx-font-size: 24");

                value=new Div();


                circle.setFill(new Color(0.2,1,0,1));
                Nodes.put(stack,scrab);
                break;
            case "Addition":
                label.setText("+");
                label.setStyle("-fx-font-size: 24");

                value=new Add();


                circle.setFill(new Color(0.2,1,0,1));
                Nodes.put(stack,scrab);
                break;
            default:
                System.out.println("type was not selected");
                bigpane.getChildren().removeAll(op1,op2,stack);
                Nodes.remove(stack);
                Lines.remove(Integer.toString(op1.hashCode()));
                Lines.remove(Integer.toString(op2.hashCode()));
        }
        if (!first && !error){
            ast.setOp(value);
            first=true;
        }
        else if(error){
            error=false;
        }

        scrab.setOp(value);
    }

    /**
     * function to evaluate the tree
     * @param event the event that triggered this
     */
    public void Eval(ActionEvent event){
        txtresult.setText(ast.Eval().toString());
    }

    /**
     * function to Set a StackPane draggable
     * @param node the StackPane
     */
    void setDraggable(StackPane node){
        double factor = 1.3;
        node.setOnMousePressed(event->{
        });

        node.setOnMouseDragged(event->{
            double x =event.getSceneX()-nodeX-nodeR;
            double y = event.getSceneY()-nodeY-nodeR;
            node.setTranslateX(x);
            node.setTranslateY(y);

            ScrabNode s= Nodes.get(event.getSource());
            Line op1=s.getLine1();
            op1.setStartX(event.getSceneX());
            op1.setStartY(event.getSceneY());
            if(!s.united[0]){
                op1.setEndX(event.getSceneX()-nodeR*factor);
                op1.setEndY(event.getSceneY()+nodeR*factor);
            }

            Line op2=s.getLine2();
            op2.setStartX(event.getSceneX());
            op2.setStartY(event.getSceneY());
            if(!s.united[1]){
                op2.setEndX(event.getSceneX()+nodeR*factor);
                op2.setEndY(event.getSceneY()+nodeR*factor);
            }

            Line dad = s.getLine3();
            if(s.united[2]){
                dad.setEndX(event.getSceneX());
                dad.setEndY(event.getSceneY());
            }

        });
        node.setOnMouseReleased(event->{
            double x =event.getSceneX()-nodeX-nodeR;
            double y = event.getSceneY()-nodeY-nodeR;
            node.setTranslateX(x);
            node.setTranslateY(y);

            ScrabNode s= Nodes.get(event.getSource());
            Line op1=s.getLine1();
            op1.setStartX(event.getSceneX());
            op1.setStartY(event.getSceneY());
            if(!s.united[0]){
                op1.setEndX(event.getSceneX()-nodeR*factor);
                op1.setEndY(event.getSceneY()+nodeR*factor);
            }

            Line op2=s.getLine2();
            op2.setStartX(event.getSceneX());
            op2.setStartY(event.getSceneY());
            if(!s.united[1]){
                op2.setEndX(event.getSceneX()+nodeR*factor);
                op2.setEndY(event.getSceneY()+nodeR*factor);
            }

            Line dad = s.getLine3();
            if(s.united[2]){
                dad.setEndX(event.getSceneX());
                dad.setEndY(event.getSceneY());
            }
        });
    }

    /**
     * function to implement drag and drop on a Line
     * @param line the Line
     */
    private void dragAndDropLine(Line line){

        line.setOnDragDetected(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                Dragboard db = line.startDragAndDrop(TransferMode.ANY);

                ClipboardContent content = new ClipboardContent();
                content.putString(Integer.toString(line.hashCode()));

                db.setContent(content);


            }
        });

        line.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                event.consume();
            }
        });

    }

    /**
     * function to implement drag and drop on a StackPane
     * @param pane the StackPane
     */
    private void dragAndDropNode(StackPane pane){
        pane.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    String key = db.getString();
                    StackPane stack = Lines.get(key);
                    ScrabNode scrab = Nodes.get(stack);

                    // con este si funciona
                    if (scrab.getLine1().hashCode()==Integer.parseInt(key)) {

                        Operation op = scrab.getOp();
                        op.setop1(Nodes.get(pane).getOp());
                        Nodes.get(pane).setLine3(scrab.getLine1());
                        scrab.united[0]=true;
                        Nodes.get(pane).united[2]=true;
                    }
                    //con este no, no entiendo por queeee
                    if(scrab.getLine2().hashCode()==Integer.parseInt(key)){

                        Operation op = scrab.getOp();
                        op.setop2(Nodes.get(pane).getOp());
                        Nodes.get(pane).setLine3(scrab.getLine2());
                        scrab.united[1]=true;
                        Nodes.get(pane).united[2]=true;
                    }
                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();
            }
        });

        pane.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                if (event.getGestureSource() != pane &&
                        event.getDragboard().hasString()) {

                    event.acceptTransferModes(TransferMode.LINK);
                }

                event.consume();
            }
        });
    }

    /**
     * to check if a String is true or false
     * @param s the String
     * @throws TypeException when the string is not true or false
     */
    private void checkbool(String s) throws TypeException {
        if(!s.matches("true|false")){
            throw new TypeException("value isn't true or false");
        }
    }

    /**
     * to check if a String is binary and has 31 bits max
     * @param s the String
     * @throws TypeException when condicion not met
     */
    private void checkBinary(String s) throws TypeException{
        if(!s.matches("(1|0){1,31}")){
            throw new TypeException("value isn't made of 0s and 1s");
        }

    }





}