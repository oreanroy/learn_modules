export PATH=“/usr/bin/python@3.8:$PATH”

export PATH="/usr/local/opt/python@3.8/bin:$PATH"


  export NVM_DIR="$HOME/.nvm"
  [ -s "/usr/local/opt/nvm/nvm.sh" ] && . "/usr/local/opt/nvm/nvm.sh"  # This loads nvm
  [ -s "/usr/local/opt/nvm/etc/bash_completion.d/nvm" ] && . "/usr/local/opt/nvm/etc/bash_completion.d/nvm"  # This loads nvm bash_completion


## aliases
alias ex=deactivate
alias pb=pbcopy
alias tef=terraform
alias sr=source
alias activ="source ./venv/bin/activate"
alias ms="make start"


#terraform -install-autocomplete

autoload -U +X bashcompinit && bashcompinit
complete -o nospace -C /usr/local/bin/terraform terraform


#functions
# LF=left
# DN=done
task(){
  task_file=taskList.txt
  RED='\033[1;31m'
  GREEN='\033[0;32m'
  case $1 in 
    add)
      echo "add task"
      rand_hash=$RANDOM
      echo "LF ${rand_hash:0:4} $2 `date +'%d %m %y'`">>$task_file  
      ;;
    ls)
      echo "list tasks"
      while read -r line; do
        if [ "${line:0:2}" = "LF" ]
          then
            echo -e "${RED}${line:3}"
          else
            echo -e "${GREEN}${line:3}"
        fi
      done < $task_file
      ;;
    cmp)
      echo "mark as complete"
      sed -i '.txt' "s/LF $2/DN $2/g" $file
      ;;
    del)
      echo "delte task"
      sed -i '.txt' "/$2/d" $task_file
      ;;
    *)
      echo "wrong command"
      ;;
  esac
}

