package com.calmalgo.test;


/**
 This interface is implemented by Parser and Statistics as both of them write to the corresponding data file
 in their own way. Potentially additional classes that write to a data file can implement this interface.
 **/
interface FileWriter {
    void writeFile();
}
