package Data is

   type Matrix is private;
   type Vector is private;

   protected type Mutex is
        entry Seize;
        procedure Release;
    private
        Owned : Boolean := False;
    end Mutex;

   My_Mutex : Mutex;

   procedure Vector_Output(A : in Vector; N : in Integer; S: in String);
   procedure Vector_Generate (A : out Vector; N : in Integer);
   procedure Matrix_Output(A : in Matrix; N : in Integer; S: in String);
   procedure Matrix_Generate (A : out Matrix; N : in Integer);

   function F1(O : in Matrix; E : in Matrix; A : in Vector; B : in Vector; N : in Integer) return Vector;
   function F2(G : in Matrix; K : in Matrix; L : in Matrix; N : in Integer) return Matrix;
   function F3(P : in Matrix; R : in Matrix; T : in Vector; N : in Integer) return Vector;

   function Amount (A: in Vector; B: in Vector; N : in Integer) return Vector;
   function Amount (A: in Matrix; B: in Matrix; N : in Integer) return Matrix;
   function Diff (A: in Matrix; B: in Matrix; N : in Integer) return Matrix;
   function Multiple (A: in Matrix; B: in Matrix; N : in Integer) return Matrix;
   function Multiple (A: in Matrix; B: in Vector; N : in Integer) return Vector;
   function Trans (A: in Matrix; N : in Integer) return Matrix;

private
   type Vector is array(1..100) of Integer;
   type Matrix is array (1..100,1..100) of Integer;

end Data;
