import React from "react";
//import ItemsContext from "./Items";

function Details(props) {
    const {idx, items} = props;
    //const {items} = React.useContext(ItemsContext);

    return (
        <div>
            { idx > -1 ?
                <p>
                    <h3> {items[idx].id} </h3>
                    <h3> {items[idx].name} </h3>
                    <h3> {items[idx].price} </h3>
                </p>
                :
                <div> Not Selected </div>
            }
        </div>
    );
}

export default Details;