import React from "react";

function Display(props) {
    const {items, changeItemIndex} = props;
    
    return (
        <div>
            <ui>
                {
                    items.map((item, index) => {
                        return <li key={item.id} onClick={(event) => changeItemIndex(index, event)}> {item.name} </li>
                    })
                }
            </ui>
        </div>
    );
}

export default Display;