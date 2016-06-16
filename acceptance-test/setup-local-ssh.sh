#!/bin/bash -xe

mkdir -m 700 -p -v $HOME/.ssh
ssh-keygen -t rsa -N '' -f ~/.ssh/id_rsa
cat $HOME/.ssh/id_rsa.pub > ~/.ssh/authorized_keys

rm -f ~/.ssh/known_hosts
ssh \
  -o StrictHostKeyChecking=no \
  -o HostKeyAlgorithms=ssh-rsa \
  -o UserKnownHostsFile=~/.ssh/known_hosts \
  -i ~/.ssh/id_rsa \
  localhost id
ssh-keygen -f ~/.ssh/known_hosts -F localhost
