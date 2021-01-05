# PJATK_BSI_ASYM_ENCRYPT

This repository is an extension of https://github.com/MarcinRozkwitalski/PJATK_BSI_ENCRYPTION

It has been extended by two asymmetric algorithms: RSA & DSA.

# RSA
Rivest–Shamir–Adleman. The RSA algorithm involves four steps: key generation, key distribution, encryption, and decryption.

A basic principle behind RSA is the observation that it is practical to find three very large positive integers e, d, and n, such that with modular exponentiation for all integers m (with 0 ≤ m < n).

RSA involves a public key and a private key. The public key can be known by everyone, and it is used for encrypting messages. The intention is that messages encrypted with the public key can only be decrypted in a reasonable amount of time by using the private key. The public key is represented by the integers n and e; and, the private key, by the integer d (although n is also used during the decryption process, so it might be considered to be a part of the private key, too).

We have extended the RSA algorithm with SALTING and HASHING.

Salt is random data that is used as an additional input to a one-way function that hashes data, a password or passphrase. Salts are used to safeguard passwords in storage. Historically a password was stored in plaintext on a system, but over time additional safeguards were developed to protect a user's password against being read from the system. A salt is one of those methods.

A cryptographic hash function (CHF) is a mathematical algorithm that maps data of arbitrary size (often called the "message") to a bit array of a fixed size (the "hash value", "hash", or "message digest"). It is a one-way function, that is, a function which is practically infeasible to invert. Ideally, the only way to find a message that produces a given hash is to attempt a brute-force search of possible inputs to see if they produce a match, or use a rainbow table of matched hashes.

# DSA

The Digital Signature Algorithm (DSA) is a Federal Information Processing Standard for digital signatures, based on the mathematical concept of modular exponentiation and the discrete logarithm problem. DSA is a variant of the Schnorr and ElGamal signature schemes.

The DSA algorithm involves four operations: key generation (which creates the key pair), key distribution, signing and signature verification.

# Main difference between RSA and DSA

We can't use DSA to encrypt and decrypt messages, as it says in the name - DSA is a digital signature algorithm. Digital signatures are created by encrypting a hash of the message using the signer's private key, so that it can be verified using their public key. But because it is hashed, the message cannot be recovered.
