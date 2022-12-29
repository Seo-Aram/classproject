import React from 'react';

function Image({img}) {
    return (
        <div className='image-group'>
            <img src={img.src} alt={img.art}/>
            <p>{img.comment}</p>
        </div>
    );
}

export default Image;