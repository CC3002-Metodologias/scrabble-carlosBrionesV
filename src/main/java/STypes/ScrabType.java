package STypes;

import AST.Operation;

/**
 * Generic Scrabble Type
 */
public interface ScrabType extends Operation {
    ScrabString toScrabString();
}
