package com.meli.aula1morse.service;

import java.util.HashMap;
import java.util.Map;

public class MorseService implements IMorseService{

    private Map<String,Character> morseMap;

    public MorseService() {
        this.morseMap = new HashMap<>();
        morseMap.put(".-",'A');
        morseMap.put("-...",'B');
        morseMap.put("-.-.",'C');
        morseMap.put("-..",'D');
        morseMap.put(".",'E');
        morseMap.put("..-.",'F');
        morseMap.put("--.",'G');
        morseMap.put("....",'H');
        morseMap.put("..",'I');
        morseMap.put(".---",'J');
        morseMap.put("-.-",'K');
        morseMap.put(".-..",'L');
        morseMap.put("--",'M');
        morseMap.put("-.",'N');
        morseMap.put("---",'O');
        morseMap.put(".--.",'P');
        morseMap.put("--.-",'Q');
        morseMap.put(".-.",'R');
        morseMap.put("...",'S');
        morseMap.put("-",'T');
        morseMap.put("..-",'U');
        morseMap.put("...-",'V');
        morseMap.put(".--",'W');
        morseMap.put("-..-",'X');
        morseMap.put("-.--",'Y');
        morseMap.put("--..",'Z');
        morseMap.put(".----",'1');
        morseMap.put("..---",'2');
        morseMap.put("...--",'3');
        morseMap.put("....-",'4');
        morseMap.put(".....",'5');
        morseMap.put("-....",'6');
        morseMap.put("--...",'7');
        morseMap.put("---..",'8');
        morseMap.put("----.",'9');
        morseMap.put("-----",'0');
    }

    @Override
    public String morseResolver(String morse) {
        StringBuilder solvedMsg = new StringBuilder();

        StringBuilder singleChar = new StringBuilder();

        for (int i = 0; i < morse.length(); i++) {
            char singleMorse = morse.charAt(i);

            if (singleMorse == ' ' && (morse.charAt(i-1) == ' ' && morse.charAt(i+1) == ' ')) {
                solvedMsg.append(" ");
                singleChar = new StringBuilder();
                i++;
            }
            else if(singleMorse == ' '){
                solvedMsg.append(morseMap.get(singleChar.toString().trim()));
                singleChar = new StringBuilder();
                singleChar.append(singleMorse);
            }else
                singleChar.append(singleMorse);
        }

        if (!singleChar.toString().isEmpty()){
            solvedMsg.append(morseMap.get(singleChar.toString().trim()));
        }

        return solvedMsg.toString();
    }
}
