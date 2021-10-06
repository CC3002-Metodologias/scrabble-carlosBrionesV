# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

***ScrabTypes***

Implementacion de las clases correspondientes a los tipos String, Boolean, Int, Float y
binary con sus respectivas funcionalidades y los tests para ellas. Existen cuatro interfaces, SNumber para 
los tipos que operan con Floats y enteros, BinaryOperand para los que operan con Binarios y Slogic para los tipos que 
poseen la operación _Y_ lógico y _O_ lógico y por último ScrabType como una interfaz en común para cada tipo. En esta 
versión hay problemas con operaciones matemáticas y transformaciones que involucran binarios.



En los binaarios su suma se realiza bit a bit, para el resto de sus operaciones se transforma a entero
y luego pasa al tipo requerido. 

***AST***

Para el arbol AST se creó la interfaz *Operation* para los nodos y hojas del arbol,para las hojas *ScrabType* fue 
extendido de *Operation* y para los nodos se implementaron las clases *Add,And,Div,Minus,Mult,Neg,Or* representando cada 
operacion posible para los *ScrabType*. Además de esto se creó una fábrica implementando *fly weight* que puede generar
cada *ScrabType* y Variables, para estas se creó una clase *Var* que permite asignarle un valor a un nombre cualquiera
así en el arbol se crear una variable con ese nombre y se hará referencia asu valor.

***GUI***

El funcionamiento de la gui es el siguiente: para iniciarla desde intellij se debe ejecutar scrabble-carlosBriones [run]
primero se debe seleccionar el tipo de nodo que uno quiere, ingresar el valor si es necesario y luego hacer click en 
crear nuevo nodo, esto hará aparecer un nodo en la ventana con el valor correspondiente, este nodo se puede arrastrar.
Las variables no fueron implementadas y el botón de negación tampoco (por temas de mi memoria jaja).

Al crear uno de los siguientes nodos *Addition, And, Division, subtraction, Multiplication, Or* tendrán lineas,
estas se pueden seleccionar y llevando el mouse hacia otro nodo sin soltar el botón se pueden unir (queda más lindo
si el nodo padre fue creado antes que el hijo, hay que mover el nodo hijo después de la acción para que se vea la unión), 
esta característica funciona en la linea izquierda pero no en la derecha 
(no se por qué), este hecho imposibilitó que el árbol funcione de manera apropiada. 
Si el primer nodo es de ScrabbleType y se preciona evaluar entregará el valor de ese nodo.


***TESTS***
Para ejecutar los tests se debe utilizar gradle ejecutando los test en 'scrabble.test'.