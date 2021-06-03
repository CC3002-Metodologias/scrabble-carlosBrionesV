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

**The rest of the documentation is left for the users of this template to complete**

Solo existe la implementacion de las clases correspondientes a los tipos String, Boolean, Int, Float y
binary con sus respectivas funcionalidades y los tests para ellas. Existen tres interfaces de momento, SNumber para 
los tipos que operan con binarios y enteros, SFloat para los que operan con Floats y Slogic para los tipos que poseen 
la operación _Y_ lógico y _O_ lógico. En esta versión hay problemas con operaciones matemáticas y transformaciones 
que involucran binarios.

Para ejecutar los tests se debe utilizar gradle ejecutando los test en 'scrabble.test'.

En los binaarios su suma se realiza bit a bit, para el resto de sus operaciones se transforma a entero
y luego pasa al tipo requerido. 