import React from "react";
import InputWord from "./InputWord";
import PrintWord from "./PrintWord";

function Container(props) {
    const [words] = React.useState([]);

    const addWord = function(word) {
        words.push(word);
    }
    
    const delWord = function(index) {
        words.splice(index, 1);
    }

    return (
        <div className="container">
            <InputWord addWord={addWord}/>
            <PrintWord words={words} delWord={delWord}/>
        </div>
    );
}

export default Container;