import React from 'react';
import Article from "./article";

function Section({articleList}) {
    return (
        <section>
            {
                articleList.map(article => <Article article={article}/>)
            }
        </section>
    );
}

export default Section;