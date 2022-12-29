import React from "react";
import InputWord from "./InputWord";
import PrintWord from "./PrintWord";

function Container(props) {
    const [words, setWords] = React.useState([]);

    const addWord = function(word) {
        //words.push(word);
        setWords([...words, word]);
    }
    
    const delWord = function(word) {
        //words.splice(index, 1);
        setWords(words.filter(w => w !== word))
    }

    return (
        <div className="container">
            <InputWord addWord={addWord}/>
            <PrintWord words={words} delWord={delWord}/>
        </div>
    );
}

export default Container;