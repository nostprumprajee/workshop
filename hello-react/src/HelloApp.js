import React from 'react'
function Hello(props) {
    return <h1>Test! {props.name}</h1>
  }
class HelloApp extends React.Component {
    constructor(props) {
    super(props)

    this.state = {
        counter: 0
    }

    this.handleClick = this.handleClick.bind(this)
    }

    handleClick() {
      this.setState({
          counter: this.state.counter + 1
      })
    }

    render() {
        return (
      <React.Fragment>
        <Hello name="Nost" />
        <h1>Nost! React</h1>
        <p>{this.props.message}</p>
        <button onClick={this.handleClick}>Click me!</button>
        <p>Total click : {this.state.counter}</p>
      </React.Fragment>
        )
    }
}

export default HelloApp