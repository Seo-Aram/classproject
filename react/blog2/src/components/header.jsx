import React from 'react';

function Header({title, subTitle}) {
    return (
        <header>
            <h1 className="title">{title}</h1>
            <p>
                {subTitle}
            </p>
        </header>
    );
}

export default Header;