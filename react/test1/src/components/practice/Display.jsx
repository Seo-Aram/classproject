import React from "react";
import ItemsContext from "./Items";

function Display(props) {
    const {items, changeItemId} = React.useContext(ItemsContext);
    
    return (
        <div>
            <ui>
                {
                    items.map((item, index) => {
                        return <li key={item.id} onClick={(event) => changeItemId(index, event)}> {item.name} </li>
                    })
                }
            </ui>
        </div>
    );
}

export default Display;