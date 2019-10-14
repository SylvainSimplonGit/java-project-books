import sys
import re
with open(sys.argv[1], encoding='utf-8', mode = 'r') as input, open(sys.argv[2], encoding='utf-8', mode = "w") as output:
    for line in input:
        for word in re.findall(r'\w+', line):
            output.write(word.lower())
            output.write('\n')