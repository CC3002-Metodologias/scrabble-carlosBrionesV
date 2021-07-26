package gui;

import AST.AST;
import AST.Operations.Operation;
import AST.ScrabFactory;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Scrabble extends Application {

    private ScrabFactory factory = new ScrabFactory();
    private ArrayList<Operation> ops = new ArrayList<>();
    private String type = "";
    private AST ast = new AST();

    @Override
    public void start(Stage primaryStage) {

        int width=800;
        int height=600;

        BorderStroke stroke = new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                null,new BorderWidths(1));
        Border border = new Border(stroke);

        //FONDO
        Pane bigpane = new Pane();
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

        Button Binary = new Button("Binary");
        GridPane.setRowIndex(Binary,0);
        GridPane.setColumnIndex(Binary,1);

        Button Float = new Button("Float");
        GridPane.setRowIndex(Float,0);
        GridPane.setColumnIndex(Float,2);

        Button Bool = new Button("Boolean");
        GridPane.setRowIndex(Bool,1);
        GridPane.setColumnIndex(Bool,0);

        Button String = new Button("String");
        GridPane.setRowIndex(String,1);
        GridPane.setColumnIndex(String,1);

        Button Var = new Button("Var");
        GridPane.setRowIndex(Var,1);
        GridPane.setColumnIndex(Var,2);

        btnscrabs.getChildren().addAll(Int,Float,Binary,Bool,String,Var);

        //TO MAKE A SCRAB
        TitledPane Scrabs = new TitledPane("Set to Scrabble",btnscrabs);


        GridPane btnOps = new GridPane();

        //buttons for OPERATIONS

        Button And = new Button("And");
        GridPane.setRowIndex(And,0);
        GridPane.setColumnIndex(And,0);

        Button Or = new Button("Or");
        GridPane.setRowIndex(Or,0);
        GridPane.setColumnIndex(Or,1);

        Button Add = new Button("Addition");
        GridPane.setRowIndex(Add,0);
        GridPane.setColumnIndex(Add,2);

        Button Minus = new Button("Subtract");
        GridPane.setRowIndex(Minus,1);
        GridPane.setColumnIndex(Minus,0);

        Button Mult = new Button("Multiplication");
        GridPane.setRowIndex(Mult,1);
        GridPane.setColumnIndex(Mult,1);

        Button Div = new Button("Division");
        GridPane.setRowIndex(Div,1);
        GridPane.setColumnIndex(Div,2);

        btnOps.getChildren().addAll(Div,Mult,Add,Minus,And,Or);

        //TO MAKE A OPERATION
        TitledPane Op = new TitledPane("Set to operation",btnOps);

        SetBox.getChildren().addAll(Scrabs,Op);

        HBox current = new HBox();
        Label currentTypeLabel = new Label("New Node Type: ");
        currentTypeLabel.setFont(new Font("Arial",15));

        TextField currentTypetxt = new TextField(type);
        currentTypetxt.setDisable(true);
        currentTypetxt.setBorder(border);

        current.getChildren().addAll(currentTypeLabel,currentTypetxt);
        TypeBox.getChildren().addAll(SetBox,current);

        //INPUT , CREATION & EVALUATION
        VBox input = new VBox();

        VBox newNodeBox = new VBox();
        TextField txtNode=new TextField();
        txtNode.setPromptText("Enter value or var Name");
        Button createNode= new Button("Create new Node");
        newNodeBox.getChildren().addAll(txtNode,createNode);
        newNodeBox.setBorder(border);

        VBox newVarBox = new VBox();
        HBox varsInfo = new HBox();
        TextField VarName=new TextField();
        VarName.setPromptText("Name");
        TextField VarValue=new TextField();
        VarValue.setPromptText("Value");
        varsInfo.getChildren().addAll(VarName,VarValue);

        Button createVar= new Button("Create new Var");

        HBox EvalBox = new HBox();
        Label resultLabel=new Label("  result: ");
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setFont(new Font("Arial",15));
        TextField result = new TextField();
        result.setBorder(border);
        result.setDisable(true);

        Button Eval= new Button("Evaluate Tree");
        newVarBox.setBorder(border);

        EvalBox.getChildren().addAll(Eval,resultLabel,result);

        newVarBox.getChildren().addAll(varsInfo,createVar);

        input.getChildren().addAll(newNodeBox,newVarBox,EvalBox);

        NodeMenu.getChildren().addAll(TypeBox,input);






        NodeMenu.setBorder(border);

        bigpane.getChildren().add(NodeMenu);

        Scene scene = new Scene(bigpane, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
            launch(args);
    }
}
