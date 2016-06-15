;
; name:
; ACT_R_task_001_genealogy.lisp
;

(clear-all)

(define-model semantic

(sgp :esc t :lf .05)

(chunk-type property object attribute value)
(chunk-type relation person_1 attribute person_2 judgment)

(add-dm
  (Kate) (Andy) (Josh) (Eve) (Amy) (Tim)
  (gender) (female) (male)
  (parent) (father) (mother)
  (sibling) (brother) (sister)
  (grandmom_father)
  (yes) (no) (pending)
 
 (p1 ISA property object Kate attribute gender value female)
 (p2 ISA property object Andy attribute gender value male)

 (p3 ISA property object Josh attribute gender value male)
 (p4 ISA property object Josh attribute mother value Kate)
 (p5 ISA property object Josh attribute father value Andy)
 
 (p6 ISA property object Eve attribute gender value female)

 (p7 ISA property object Amy attribute gender value female)
 (p8 ISA property object Amy attribute father value Josh)
 (p9 ISA property object Amy attribute mother value Eve)

 (p10 ISA property object Tim attribute gender value male)
 (p11 ISA property object Tim attribute father value Josh)
 (p12 ISA property object Tim attribute mother value Eve)
 
 
 ; Parentship working
 (g1 ISA relation person_1 Amy attribute parent person_2 Josh)
 ; Parentship NOT working
 (g2 ISA relation person_1 Josh attribute parent person_2 Amy)
 
 ; Fathership working
 (g3 ISA relation person_1 Amy attribute father person_2 Josh)
 ; Fathership NOT working
 (g4 ISA relation person_1 Amy attribute father person_2 Eve)
 
 ; Siblings working
 (g5 ISA relation person_1 Amy attribute sibling person_2 Tim)
 ; Siblings NOT working
 (g6 ISA relation person_1 Eve attribute sibling person_2 Josh)
 
 ; Sister working
 (g7 ISA relation person_1 Tim attribute sister person_2 Amy)
 ; Brother NOT working
 (g8 ISA relation person_1 Tim attribute brother person_2 Amy)
 
 ; Grandmother from father side working
 (g9 ISA relation person_1 Tim attribute grandmom_father person_2 Kate)
 ; Grandmother from father side NOT working
 (g10 ISA relation person_1 Amy attribute grandmom_father person_2 Andy)
 
)



(P is-father
   =goal>
      person_1    =pe1
      attribute   father
	  person_2	  =pe2
      judgment    nil
==>
   =goal>
      judgment    pending
   +retrieval>
      object      =pe1
	  attribute   father
      value       =pe2
)

(P is-father-verify
   =goal>
      person_1    =pe1
      attribute   father
	  person_2    =pe2
      judgment    pending
   =retrieval>
      object      =pe1
      attribute   father
	  value		  =pe2
==>
   =goal>
      judgment    yes
	  !output!    YES
    
)

(P is-mother
   =goal>
      person_1    =pe1
      attribute   mother
	  person_2	  =pe2
      judgment    nil
==>
   =goal>
      judgment    pending
   +retrieval>
      object      =pe1
	  attribute   mother
      value       =pe2
)

(P is-mother-verify
   =goal>
      person_1    =pe1
      attribute   mother
	  person_2    =pe2
      judgment    pending
   =retrieval>
      object      =pe1
      attribute   mother
	  value		  =pe2
==>
   =goal>
      judgment    yes
	  !output!    YES
    
)


(P fail
   =goal>
      judgment    pending
    
   ?retrieval>
      buffer       failure
==>
   =goal>
      judgment    no
	  !output!    NO
)

(P is-parent
    =goal>
	  person_1    =pe1
      attribute   parent
      person_2    =pe2
	  judgment    nil
==>
    =goal>
      judgment    pending
    +retrieval>
      object      =pe2
      attribute   gender
)

(P is-parent-female
    =goal>
	  person_1    =pe1
      attribute   parent
      person_2    =pe2
      judgment    pending
    =retrieval>
      object      =pe2
      attribute   gender
      value       female
==>
    =goal>
      attribute   mother
      judgment    nil
)

(P is-parent-male
    =goal>
	  person_1    =pe1
      attribute   parent
      person_2    =pe2
      judgment    pending
    =retrieval>
      object      =pe2
      attribute   gender
      value       male
==>
    =goal>
      attribute   father
      judgment    nil
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;               SIBLNGS
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(P is-sister
   =goal>
	  person_1    =pe1
      attribute   sister
      person_2    =pe2
	  judgment    nil
==>
    =goal>
      judgment    pending
    +retrieval>
      object      =pe2
      attribute   gender
      value       female
)

(P is-sister-verify
   =goal>
      person_1    =pe1
      attribute   sister
	  person_2    =pe2
      judgment    pending
   =retrieval>
      attribute   gender
	  value		  female
==>
   =goal>
      attribute   sibling
      judgment    nil
)

(P is-brother
   =goal>
	  person_1    =pe1
      attribute   brother
      person_2    =pe2
	  judgment    nil
==>
    =goal>
      judgment    pending
    +retrieval>
      object      =pe2
      attribute   gender
      value       male
)

(P is-brother-verify
   =goal>
      person_1    =pe1
      attribute   brother
	  person_2    =pe2
      judgment    pending
   =retrieval>
      attribute   gender
	  value		  =pe2
==>
   =goal>
      attribute   sibling
      judgment    nil
)

(P is-sibling
    =goal>
	  person_1    =pe1
      attribute   sibling
      person_2    =pe2
	  judgment    nil
==>
    =goal>
      judgment    pending
    +retrieval>
      object      =pe1
      attribute   father
)

(P is-sibling-ask-father
    =goal>
	  person_1    =pe1
      attribute   sibling
      person_2    =pe2
	  judgment    pending
    =retrieval>
	  object      =pe1
      attribute   father
	  value		  =pe3
==>
    =goal>
      person_1    =pe2
      attribute   father
      person_2    =pe3
	  judgment    nil
)

(P is-grandmom-father
   =goal>
	  person_1    =pe1
      attribute   grandmom_father
      person_2    =pe2
	  judgment    nil
==>
    =goal>
      judgment    pending
	+retrieval>
      object      =pe2
      attribute   gender
      value       female
)

(P is-grandmom-father-verify
   =goal>
      person_1    =pe1
      attribute   grandmom_father
	  person_2    =pe2
      judgment    pending
   =retrieval>
      attribute   gender
	  value		  female
==>
   +retrieval>
      object      =pe1
      attribute   father  
)

(P is-grandmom-father-mom
   =goal>
      person_1    =pe1
      attribute   grandmom_father
	  person_2    =pe2
      judgment    pending
   =retrieval>
      attribute   father
	  value		  =pe3
==>
   =goal>
	  person_1    =pe3
      attribute   mother
	  person_2    =pe2
      judgment    nil
)

(goal-focus g1)
)
