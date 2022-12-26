
// 함수형 컴포넌트 -> 엘리먼트 반환(DOM)
function MyButton(prop) {
    // hook을 사용하기 위해서 React.useState호출
    const [isClicked, setIsClicked] = React.useState(false);
    return React.createElement(
        'button',
        {onClick: () => {setIsClicked(!isClicked)}},
        isClicked ? '클릭됨' : '클릭'
    );
}

const domContainer = document.querySelector('#root-container');
ReactDOM.render(React.createElement(MyButton), domContainer);
