import React from 'react';
import Image from "./image";

function Article({article}) {
    return (
        <article>
            <h2>{article.title}</h2>
            <p className='article-date'>{article.date}</p>
            {
                article.imgs.length > 0 && article.imgs.map(img => <Image img={img}/>)
            }
            <p className='lh-180'>
                {article.content}
            </p>
        </article>
    );
}

export default Article;