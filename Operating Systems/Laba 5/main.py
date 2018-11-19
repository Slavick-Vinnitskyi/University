import json


def main():
    local_parts, my_dict = [], []

    f = open("emails.txt", "r")
    f1 = f.readlines()
    for line in f1:
        local_parts.append(line.strip("\n").strip("\"").split("@"))
    for part in local_parts:
        my_dict.append({"local part": part[0], "domain": part[1].split(".")})
    with open('parsed_emails.json', "w") as outfile:
        json.dump(my_dict, outfile)


if __name__ == "__main__":
    main()
