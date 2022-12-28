import React from "react";

class Notification extends React.Component {
    constructor(props) {
        super(props);
        this.state = {checked:false};
    }

    componentDidMount(){
        console.log('componentDidMount Call!!!');
        this.setState({checked: true});
    }

    componentDidUpdate(){
        console.log('componentDidUpdate Call!!!');
    }

    componentWillUnmount(){
        console.log('componentWillUnmount Call!!!');
    }

    render() {
        return (
            <div>
                <span> {this.props.message} </span>
            </div>
        );
    }
}

export default Notification;