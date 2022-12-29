import React from 'react';
import SideMenu from "./sideMenu";

function Aside({sideMenu}) {
    return (
        <aside>
            {
                sideMenu.map(menu => <SideMenu title={menu.title} category={menu.category} />)
            }
        </aside>
    );
}

export default Aside;