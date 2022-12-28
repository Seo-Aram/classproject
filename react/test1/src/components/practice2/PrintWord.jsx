import React from "react";

function PrintWord(props) {
    const {words, delWord} = props;

    return (
        <div>
            <ul>
                {
                    words.map((word, index) => {
                        return <li key={index}> {word} <button onClick={(event) => delWord(index, event)}> X </button> </li>
                    })
                }
            </ul>
        </div>
    );
}

export default PrintWord;