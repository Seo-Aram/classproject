import React from 'react';

function SearchInput(props) {
    return (
        <div className='input-box'>
            <input type="text"/>
            <input type="button" value="search"/>
        </div>
    );
}

export default SearchInput;