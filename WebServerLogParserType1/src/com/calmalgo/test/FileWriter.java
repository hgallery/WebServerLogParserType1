package com.calmalgo.test;


/**
 Both Parser and Statistics write data to the corresponding file.
 Because of that both of them implement FileWriter.
 **/
interface FileWriter {
    void writeFile();
}
