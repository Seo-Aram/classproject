import React from 'react';
import SideMenu from "./sideMenu";
import SearchInput from "./searchInput";

function Navigator({navMenu}) {
    return (
        <nav>
            <SideMenu category={navMenu}/>
            <SearchInput/>
        </nav>
    );
}

export default Navigator;