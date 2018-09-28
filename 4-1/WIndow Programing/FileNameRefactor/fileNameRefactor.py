import glob, os

def rename1(dir, pattern, titlePattern) :
    for pathAndFilename in glob.iglob(os.path.join(dir, pattern)):
        title, ext = os.path.splitext(os.path.basename(pathAndFilename))
        os.rename(pathAndFilename, os.path.join(dir, titlePattern % title + ext))

def rename2(path, fileType) :
    index = 0;
    for filename in os.listdir(path):
        if filename.endswith is fileType :
            os.rename(path+filename, path+filename+str(index))
            index+=1;


def main() :
    path = "C:\\Users\\User\\Desktop\\새 폴더\\"
    fileType = "png"
    rename2(path, fileType)
