import React from 'react';
import Ul from "./ul";

function SideMenu({title, category}) {
    return (
        <div>
            {title && <h4>{title}</h4>}
            <Ul category={category}/>
        </div>
    );
}

export default SideMenu;