import React from "react";

function InputWord(props) {
    const {addWord} = props;
    
    const [value, setValue] = React.useState('')

    const handleChange = (event) => {
        setValue(event.target.value)
    }

    const handleSubmit =  (event) => {
        event.preventDefault();
        addWord(value);
        setValue('');
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" value={value} onChange={handleChange} placeholder='단어 입력'/> 
                <button type="submit"> 추가 </button>
            </form>
        </div>
    );
}

export default InputWord;