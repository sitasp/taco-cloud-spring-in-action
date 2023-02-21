import React, { Component } from 'react';
import axios from 'axios';
import GroupTacos from './GroupTacos';

class RecentTacosComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            recentTacos: []
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/design/recent')
            .then(response => this.setState({ recentTacos: response.data }))
            .catch(error => console.log(error));
    }

    render() {
        const { recentTacos } = this.state;
        return (
            <div>
                <h1>Recent Tacos</h1>
                <GroupTacos tacos={recentTacos} />
            </div>
        );
    }
}

export default RecentTacosComponent;