import React from "react";

function Player(props) {
    const name = props.playerName;
    const number = props.playerNumber;

    return (
        <ul>
            <li>{name}</li>
            <li>{number}</li>
        </ul>
    )
}

export default Player;