// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract DecentralizedVoting {

    struct Proposal {
        string name;
        uint votes;
    }

    address public owner;
    Proposal[] public proposals;

    mapping(address => bool) public authorizedVoter;
    mapping(address => bool) public hasVoted;

    constructor() {
        owner = msg.sender;
    }

    function authorizeVoter(address voter) public {
        require(msg.sender == owner, "Only owner can authorize");
        authorizedVoter[voter] = true;
    }

    function addProposal(string memory name) public {
        proposals.push(Proposal(name, 0));
    }

    function vote(uint proposalId) public {
        require(authorizedVoter[msg.sender], "Not an authorized voter");
        require(!hasVoted[msg.sender], "Already voted");
        require(proposalId < proposals.length, "Invalid proposal");

        proposals[proposalId].votes++;
        hasVoted[msg.sender] = true;
    }

    function getWinner() public view returns (string memory) {
        require(proposals.length > 0, "No proposals");

        uint winner = 0;

        for (uint i = 1; i < proposals.length; i++) {
            if (proposals[i].votes > proposals[winner].votes) {
                winner = i;
            }
        }

        return proposals[winner].name;
    }

    function getProposalCount() public view returns (uint) {
        return proposals.length;
    }
}
