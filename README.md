Decentralized Voting System with Smart Contracts
Project 2 - Blockchain Technology
Project Overview
The Decentralized Voting System is a blockchain-based voting application developed using a Solidity smart contract.
The system allows the contract owner to authorize specific voters. Authorized voters can cast their votes for available proposals. The system also prevents a voter from voting more than once.
Aim
To design and develop a decentralized voting system using a Solidity smart contract for secure and transparent voting.
Features
•	Proposal submission
•	Voter authorization
•	Vote casting
•	Double-voting prevention
•	Dynamic winner calculation
Technology Used
•	Solidity
•	Blockchain Technology
•	Smart Contracts
•	Remix IDE
Smart Contract
The main smart contract is:
DecentralizedVoting.sol
Working
1.	The contract owner authorizes specific voter addresses.
2.	Proposals are added to the voting system.
3.	Authorized voters can cast their votes.
4.	The contract checks whether the voter has already voted.
5.	A voter can vote only once.
6.	The votes are counted for each proposal.
7.	The proposal with the highest number of votes is returned as the winner.
Main Functions
authorizeVoter()
Authorizes a specific blockchain address to participate in voting.
addProposal()
Adds a new proposal to the voting system.
vote()
Allows an authorized voter to vote for a proposal and prevents double voting.
getWinner()
Compares the proposal vote counts and returns the winning proposal.
getProposalCount()
Returns the total number of proposals.
Project Structure
Decentralized-Voting-System
│
├── DecentralizedVoting.sol
└── README.md
Expected Test
Example proposals:
•	Alice
•	Bob
An authorized voter can vote for one proposal. If the same voter tries to vote again, the transaction is rejected with the message:
Already voted
The proposal with the highest number of votes is returned as the winner.
Expected Result
The system successfully provides voter authorization, proposal submission, vote casting, double-voting prevention, and dynamic winner calculation.
Conclusion
This project demonstrates the use of Solidity smart contracts to implement a decentralized voting system with basic access control and secure voting logic.

