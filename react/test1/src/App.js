import logo from './logo.svg';
import './App.css';
import Notification from './components/Notification';
import Container from './components/practice1/Container';

/*function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}*/

function App() {
  return(
    //<Notification message='안녕하세요'/>
    <Container/>
  );
}

export default App;
