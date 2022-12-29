import React from 'react';
import Section from "./section";
import Aside from "./aside";

function Wrap({sideMenu, articleList}) {
    return (
        <div className='wrap'>
            <Section articleList={articleList}/>
            <Aside sideMenu={sideMenu}/>
        </div>
    );
}

export default Wrap;